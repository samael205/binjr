package eu.fthevenet.binjr.controllers;

import eu.fthevenet.binjr.data.workspace.Worksheet;
import eu.fthevenet.util.ui.charts.ZonedDateTimeAxis;
import javafx.beans.property.BooleanProperty;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.ValueAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * An implementation of {@link WorksheetController} that provides a {@link StackedAreaChart} chart.
 *
 * @author Frederic Thevenet
 */
public class StackedAreaChartWorksheetController extends WorksheetController {

    /**
     * Initializes a new instance of the {@link StackedAreaChartWorksheetController} class
     *
     * @param worksheet          the {@link Worksheet} instance associated to the controller
     */
    public StackedAreaChartWorksheetController(Worksheet worksheet) throws IOException {
        super(worksheet);
    }

    @Override
    protected XYChart<ZonedDateTime, Double> buildChart(ZonedDateTimeAxis xAxis, ValueAxis<Double> yAxis, BooleanProperty showSymbolsProperty) {
        StackedAreaChart<ZonedDateTime, Double> newChart = new StackedAreaChart<>(xAxis, yAxis);
        newChart.setCreateSymbols(false);
        newChart.createSymbolsProperty().bindBidirectional(showSymbolsProperty);
        return newChart;
    }
}