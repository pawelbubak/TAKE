package ai.faces;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "visualizationBean")
@RequestScoped
public class VisualizationBean implements Serializable {
    private LineChartModel lineModel;

    @PostConstruct
    public void init() {
        createLineModel();
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public LineChartModel getLineModel() {
        return lineModel;
    }

    private void createLineModel() {
        lineModel = initLinearModel();
        lineModel.setZoom(true);
        lineModel.setTitle("Linear Chart");
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(-1);
        yAxis.setMax(1);
    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = prepareFirstSeries();
        LineChartSeries series2 = prepareSecondSeries();

        model.addSeries(series1);
        model.addSeries(series2);

        return model;
    }

    private LineChartSeries prepareFirstSeries() {
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Series 1");
        for (int i = 0; i <= 360; i += 10) {
            series.set(i, Math.sin(Math.toRadians(i)));
        }
        return series;
    }

    private LineChartSeries prepareSecondSeries() {
        LineChartSeries series = new LineChartSeries();
        series.setLabel("Series 2");
        for (int i = 0; i <= 360; i += 10) {
            series.set(i, Math.cos(Math.toRadians(i)));
        }
        return series;
    }
}
