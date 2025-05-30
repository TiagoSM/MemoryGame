package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A classe ScoreManager é responsável por gerenciar a pontuação dos jogadores.
 * Ela permite carregar e salvar pontuações em um arquivo JSON utilizando a biblioteca Gson.
 */
public class ScoreManager {
    private static String fileName = "";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Construtor da classe ScoreManager.
     *
     * @param fileName O nome do arquivo onde as pontuações serão armazenadas.
     */
    public ScoreManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Carrega a lista de pontuações a partir do arquivo especificado.
     *
     * @return Uma lista de objetos Score representando as pontuações carregadas.
     *         Se ocorrer um erro ao ler o arquivo, uma lista vazia será retornada.
     */
    public static List<Score> loadScores() {
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, new TypeToken<List<Score>>() {}.getType());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Salva uma nova pontuação no arquivo, mantendo apenas as 10 melhores pontuações.
     *
     * @param score O objeto Score a ser salvo.
     */
    public static void saveScore(Score score) {
        List<Score> scores = loadScores();
        scores.add(score);
        Collections.sort(scores);
        if (scores.size() > 10) {
            scores = scores.subList(0, 10);
        }

        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(scores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}