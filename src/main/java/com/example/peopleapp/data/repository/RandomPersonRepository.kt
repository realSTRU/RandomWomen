package com.example.peopleapp.data.repository

import com.example.peopleapp.data.remote.api.RandomPersonApi
import com.example.peopleapp.data.remote.dto.PersonDto
import com.example.peopleapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RandomPersonRepository @Inject constructor(private val api:RandomPersonApi){
    fun getRandomPerson() : Flow<Resource<List<PersonDto>>> = flow{
        try{
            emit(Resource.Loading())
            val person = api.getPerson()
            emit(Resource.Success(person.result))
        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "Verificar Conexion"))
        }catch (e: HttpException)
        {
            emit(Resource.Error(e.message()?:"Error HTTP"))
        }
    }
}