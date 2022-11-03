package com.example.techlife

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //anotaciones de ROOM
data class Project(

    //ROOM necesariamente debe gener un PK
    @PrimaryKey(autoGenerate = true)
    var id: Int?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "description")
    var description:String?,

    @ColumnInfo(name = "ongname")
    var ongname:String?,

    @ColumnInfo(name = "direction")
    var direction:String?,

    @ColumnInfo(name = "duration")
    var duration:String?,

    @ColumnInfo(name = "dateStart")
    var dateStart:String?,
)