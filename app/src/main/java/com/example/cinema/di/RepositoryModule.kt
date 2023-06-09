package com.example.cinema.di

import com.example.cinema.data.repository.FileRepositoryImpl
import com.example.cinema.data.repository.GenreRepositoryImpl
import com.example.cinema.data.repository.MovieRepositoryImpl
import com.example.cinema.data.repository.PrivilegeRepositoryImpl
import com.example.cinema.data.repository.RoleRepositoryImpl
import com.example.cinema.data.repository.UserRepositoryImpl
import com.example.cinema.domain.repository.FileRepository
import com.example.cinema.domain.repository.GenreRepository
import com.example.cinema.domain.repository.MovieRepository
import com.example.cinema.domain.repository.PrivilegeRepository
import com.example.cinema.domain.repository.RoleRepository
import com.example.cinema.domain.repository.UserRepository
import com.example.cinema.domain.usecase.movie.GetMovieJsonUseCase
import org.koin.dsl.module

val repositoryModule = module {

    single<MovieRepository> {
        MovieRepositoryImpl(
            movieStorage = get(),
            movieMapper = get(),
            userMapper = get()
        )
    }

    single<GenreRepository> {
        GenreRepositoryImpl(
            genreMapper = get()
        )
    }

    single<UserRepository> {
        UserRepositoryImpl(
            userMapper = get(),
            roleMapper = get()
        )
    }

    single<PrivilegeRepository> {
        PrivilegeRepositoryImpl(
            privilegeMapper = get()
        )
    }

    single<RoleRepository> {
        RoleRepositoryImpl(
            roleMapper = get(),
            privilegeMapper = get()
        )
    }

    single<FileRepository> {
        FileRepositoryImpl(
            context = get()
        )
    }
}