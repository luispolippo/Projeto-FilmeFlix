package com.polippo.filmesflix.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.polippo.filmesflix.R
import com.polippo.filmesflix.model.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listOfMovies = arrayListOf(
            Movie(
                    id = 0,
                    titulo = "Titanic",
                    descricao = null,
                    imagem = null,
                    dataLancamento = null
            ),
            Movie(
                    id = 1,
                    titulo = "Central do Brasil",
                    descricao = null,
                    imagem = null,
                    dataLancamento = null
            )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateList()
    }

    private fun populateList(){
        movieList.apply {
            hasFixedSize()
            adapter = MoviesAdapter(listOfMovies)
        }
    }
}