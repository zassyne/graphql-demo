package com.zassyne.userservice.configs

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.zassyne.userservice.resolvers.CraftsmanQuery
import graphql.execution.batched.BatchedExecutionStrategy
import graphql.schema.GraphQLSchema
import graphql.servlet.DefaultExecutionStrategyProvider
import graphql.servlet.DefaultGraphQLSchemaProvider
import graphql.servlet.ExecutionStrategyProvider
import graphql.servlet.GraphQLSchemaProvider
import io.leangen.graphql.GraphQLSchemaGenerator
import io.leangen.graphql.generator.mapping.common.*
import io.leangen.graphql.generator.mapping.strategy.AnnotatedScalarStrategy
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder
import io.leangen.graphql.metadata.strategy.type.DefaultTypeInfoGenerator
import io.leangen.graphql.metadata.strategy.type.TypeInfoGenerator
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Type

@Configuration
class GraphQLConfig(private val craftsmanQuery: CraftsmanQuery) {

    @Bean
    fun graphqlSchema(): GraphQLSchema {
        val scalarStrategy = AnnotatedScalarStrategy()

        return GraphQLSchemaGenerator()
            .withResolverBuilders(AnnotatedResolverBuilder())
            .withOperationsFromSingleton(craftsmanQuery, CraftsmanQuery::class.java)
            .withValueMapperFactory(
                JacksonValueMapperFactory(null, DefaultTypeInfoGenerator(), object: JacksonValueMapperFactory.AbstractClassAdapterConfigurer() {
                    override fun configure(objectMapper: ObjectMapper?, abstractTypes: MutableSet<Type>?, basePackage: String?, metaDataGen: TypeInfoGenerator?): ObjectMapper {
                        objectMapper?.registerModule(KotlinModule())
                        return super.configure(objectMapper, abstractTypes, basePackage, metaDataGen)
                    }
                })
            )
            .withOutputConverters(
                IdAdapter(), ObjectScalarAdapter(scalarStrategy), MapToListTypeAdapter<String, Any>(scalarStrategy),
                VoidToBooleanTypeAdapter(), CollectionToListOutputConverter(),
                OptionalIntAdapter(), OptionalLongAdapter(), OptionalDoubleAdapter(),
                OptionalAdapter(), StreamToCollectionTypeAdapter()
            )
            .generate()
    }

    @Bean
    fun graphqlSchemaProvider(graphQLSchema: GraphQLSchema): GraphQLSchemaProvider {
        return DefaultGraphQLSchemaProvider(graphQLSchema)
    }

    @Bean
    fun graphqlExecutionStrategyProvider(): ExecutionStrategyProvider {
        return DefaultExecutionStrategyProvider(
            BatchedExecutionStrategy())
    }
}