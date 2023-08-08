package com.example.movfinal;
import com.example.movfinal.MovieInfoFetcher;
import com.example.movfinal.MovieSearchResult;
import com.example.movfinal.MovieInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainController {

    @FXML private Label titleLabel;
    @FXML private TextField movieNameField;
    @FXML private Button searchButton;
    @FXML private ListView<String> movieList;
    @FXML private VBox movieDetailsBox;
    @FXML private Label ratedLabel;
    @FXML private Label releaseDateLabel;
    @FXML private Label runtimeLabel;
    @FXML private Label genreLabel;
    @FXML private Label ratingLabel;
    @FXML private TextArea plotArea;
    @FXML private Button backButton;

    @FXML
    private void initialize() {
        // Initialize your UI components and event handlers here
    }

    @FXML
    private void handleSearchButton(ActionEvent event) {
        String movieName = movieNameField.getText().trim();
        if (!movieName.isEmpty()) {
            movieList.getItems().clear(); // Clear existing items

            // Fetch movie search results
            MovieSearchResult movieSearchResult = MovieInfoFetcher.searchMovies(movieName);
            if (movieSearchResult != null && movieSearchResult.getSearch() != null) {
                for (MovieInfo movieInfo : movieSearchResult.getSearch()) {
                    movieList.getItems().add(movieInfo.getTitle());
                }
            }
        }
    }


    @FXML
    private void handleMovieListClick(MouseEvent event) {
        String selectedMovieTitle = movieList.getSelectionModel().getSelectedItem();
        if (selectedMovieTitle != null) {
            // Fetch and display detailed movie information
            MovieInfo movieInfo = MovieInfoFetcher.fetchMovieInfo(selectedMovieTitle);
            if (movieInfo != null) {
                ratedLabel.setText("Rated: " + movieInfo.getRated());
                releaseDateLabel.setText("Release Date: " + movieInfo.getReleased());
                runtimeLabel.setText("Runtime: " + movieInfo.getRuntime());
                genreLabel.setText("Genre: " + movieInfo.getGenre());
                ratingLabel.setText("IMDb Rating: " + movieInfo.getImdbRating());
                plotArea.setText(movieInfo.getPlot());

                movieDetailsBox.setVisible(true);
            }
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        movieDetailsBox.setVisible(false);
    }
}

