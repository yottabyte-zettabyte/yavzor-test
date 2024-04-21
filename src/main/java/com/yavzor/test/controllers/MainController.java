package com.yavzor.test.controllers;

import com.yavzor.test.utils.RoundUtil;
import jakarta.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.data.NumericPoint;
import org.primefaces.model.charts.line.LineChartDataSet;
import org.primefaces.model.charts.line.LineChartOptions;
import org.primefaces.model.charts.optionconfig.title.Title;
import org.primefaces.model.charts.scatter.ScatterChartModel;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MainController implements Serializable {

    @Getter @Setter private int aValue;
    @Getter @Setter private int bValue;
    @Getter @Setter private int cValue;
    @Getter @Setter private double yValue;

    @Getter private double xResult;
    @Getter private double patialResult;

    @Getter @Setter private ScatterChartModel chartModel;


    @PostConstruct
    public void init() {
        refreshChart();
    }

    public void calculate() {
        patialResult = Math.sqrt(Math.pow(bValue, 2d) - 4*aValue*cValue);
        xResult = (bValue + patialResult) / 2*aValue;
    }

    public void roundResult() {
        patialResult = RoundUtil.round(patialResult, 1);
        xResult = RoundUtil.round(xResult, 1);
    }

    public void refreshChart() {
        chartModel = new ScatterChartModel();
        ChartData chartData = new ChartData();

        LineChartDataSet dataSet = new LineChartDataSet();
        dataSet.setData(List.of(new NumericPoint(xResult, yValue)));
        dataSet.setLabel("Цвет координат (x, y)");
        dataSet.setBorderColor("rgb(249, 24, 24)");
        dataSet.setShowLine(false);
        chartData.addChartDataSet(dataSet);

        int maxXValue = xResult > 0.0 ? (int) (xResult * 2) : 10;
        int maxYValue = yValue  > 0.0 ? (int) (yValue  * 2) : 10;

        CartesianLinearAxes xAxis = new CartesianLinearAxes();
        xAxis.setType("linear");
        xAxis.setPosition("bottom");
        xAxis.setMax(maxXValue);
        xAxis.setMin(-1 * maxXValue);

        CartesianLinearAxes yAxis = new CartesianLinearAxes();
        yAxis.setType("linear");
        yAxis.setPosition("left");
        yAxis.setMax(maxYValue);
        yAxis.setMin(-1 * maxYValue);

        CartesianScales scales = new CartesianScales();
        scales.addXAxesData(xAxis);
        scales.addYAxesData(yAxis);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Ось координат");

        LineChartOptions options = new LineChartOptions();
        options.setShowLines(false);
        options.setTitle(title);
        options.setScales(scales);

        chartModel.setOptions(options);
        chartModel.setData(chartData);
    }
}
