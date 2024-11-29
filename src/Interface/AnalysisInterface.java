/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author DELL
 */
public interface AnalysisInterface {

    public DefaultCategoryDataset getCinemaProfitAnalysis(int cinema_id, int year, String[] monthList);

    public DefaultCategoryDataset getYearMovieAnalysis(int cinema_id, String[] genreList, int year, String[] monthList);

     public DefaultPieDataset getYearMovieAnalysisPieChart(int cinema_id, String[] genreList, int year, String[] monthList);
    
    public DefaultCategoryDataset getMonthGenreMovieAnalysis(int cinema_id, String genreList, int year, String monthList);

    public DefaultCategoryDataset getOnlyCinemaAnalysis(int cinema_id, String[] genreList, int year, String[] monthList);

    public DefaultCategoryDataset getOnlyExpenseAnalysis(int cinema_id, int year, String[] monthList);

}
