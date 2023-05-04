package com.example.cinema.data.db.daos

import com.example.cinema.data.db.entities.MovieEntity
import com.example.cinema.data.db.tables.MoviesTable
import com.example.cinema.data.db.utils.Dao
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.find
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList

class MoviesDao(database: Database) : Dao(database) {
    private val movies get() = database.sequenceOf(MoviesTable)

    fun getAllMovies(): List<MovieEntity> {
        return movies.toList()
    }

    fun getMovieById(id: Int): MovieEntity {
        return movies.find { it.id eq id }!!
    }
}