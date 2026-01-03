package com.davidmerchan.navigation3demo.hiltNavigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltModule {
    @Binds
    abstract fun bindDemoRepository(impl: InMemoryDemoRepository): DemoRepository
}
