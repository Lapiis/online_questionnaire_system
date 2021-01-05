package edu.nwpu.util;

import edu.nwpu.domain.Questionnaire;
import edu.nwpu.domain.vo.OptionVO;
import edu.nwpu.domain.vo.QuestionDetailsVO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * JFreeChart统计图标工具
 */
public class DisplayChart {

    /**
     * 生成柱状图
     *
     * @param session
     * @param vo
     * @return
     * @throws Exception
     */
    public static String getBarChart(HttpSession session, QuestionDetailsVO vo) throws Exception{

        //创建构造对象
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //装载数据
        for(OptionVO optionVO:vo.getOptions()){
                dataset.setValue(optionVO.getSelectCount(),vo.getDescription(),optionVO.getAnswer());
        }

        //生成统计图
        JFreeChart chart  = ChartFactory.createBarChart3D("统计柱状图","选项",
                "选择数",dataset, PlotOrientation.VERTICAL,
                true,true,true);

        //向前端返回文件名
        String fileName = ServletUtilities.saveChartAsJPEG(chart,400,300,null,session);
        return fileName;
    }

    /**
     * 生成饼状图
     * @param session
     * @param vo
     * @return
     * @throws Exception
     */
    public static String getPieChart(HttpSession session, QuestionDetailsVO vo) throws Exception{

        DefaultPieDataset dataset = new DefaultPieDataset();

        //添加数据
        for(OptionVO optionVO:vo.getOptions()){
            dataset.setValue(optionVO.getAnswer(), optionVO.getSelectCount());
        }

        //赋值给真正的饼图对象，PieDataset对象
        PieDataset pie = dataset ;

        //生成饼状图
        JFreeChart chart = ChartFactory.createPieChart("统计饼状图" , pie , true , true , false) ;

        String fileName = ServletUtilities.saveChartAsJPEG(chart,400,300,null,session);
        return fileName;
    }

}