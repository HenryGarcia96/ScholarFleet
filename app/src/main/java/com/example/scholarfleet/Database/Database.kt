package com.example.scholarfleet.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database (context: Context, name:String, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        // Sentencia SQL para crear la tabla Profesor
        val createTableProfesor = "CREATE TABLE Profesor (id_profesor INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT);"

        // Sentencia SQL para crear la tabla Materia
        val createTableMateria = "CREATE TABLE Materia (id_materia INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, id_profesor INTEGER, horario TEXT, FOREIGN KEY (id_profesor) REFERENCES Profesor (id_profesor));"

        // Sentencia SQL para crear la tabla Tarea
        val createTableTarea = "CREATE TABLE Tarea (id_tarea INTEGER PRIMARY KEY AUTOINCREMENT, descripcion TEXT, fecha TEXT, completada INTEGER);"

        // Sentencia SQL para crear la tabla Evento
        val createTableEvento = "CREATE TABLE Evento (id_evento INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, descripcion TEXT, fecha TEXT, hora TEXT);"

        // Sentencia SQL para crear la tabla AgendaPersonal
        val createTableAgendaPersonal = "CREATE TABLE AgendaPersonal (id_agenda INTEGER PRIMARY KEY AUTOINCREMENT, id_materia INTEGER, id_evento INTEGER, FOREIGN KEY (id_materia) REFERENCES Materia (id_materia), FOREIGN KEY (id_evento) REFERENCES Evento (id_evento));"

        db?.execSQL(createTableProfesor)
        db?.execSQL(createTableMateria)
        db?.execSQL(createTableTarea)
        db?.execSQL(createTableEvento)
        db?.execSQL(createTableAgendaPersonal)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Profesor")
        db?.execSQL("drop table if exists Materia")
        db?.execSQL("drop table if exists Tarea")
        db?.execSQL("drop table if exists Evento")
        db?.execSQL("drop table if exists AgendaPersonal")

        onCreate(db)
    }
}