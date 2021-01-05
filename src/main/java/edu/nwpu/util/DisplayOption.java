package edu.nwpu.util;

import edu.nwpu.domain.Option;
import edu.nwpu.domain.Question;
import edu.nwpu.domain.vo.OptionVO;
import edu.nwpu.domain.vo.QuestionDetailsVO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * 用于展示问题选项的simpleTag
 *
 * @author yefeng
 */
public class DisplayOption extends SimpleTagSupport {
    private QuestionDetailsVO question;

    public void setQuestion(QuestionDetailsVO question) {
        this.question = question;
    }

    /**
     * 打印问题选项
     *
     * @throws JspException
     */
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            String outPrint = "";
            List<OptionVO> options = question.getOptions();
            String inputType = "";
            // 根据问题type设定inputType
            switch (question.getType()) {
                case 0 : inputType = "text"; break;
                case 1 : inputType = "radio"; break;
                case 2 : inputType = "checkbox"; break;
                default : throw new JspException();
            }
            // 填空题
            if ("text".equals(inputType)) {
                outPrint += "<textarea name=\"answerTo" + question.getId()
                        + "\" cols=\"80\" rows=\"5\" required=\"required\"></textarea>";
            // 选择题
            } else {
                outPrint += "<ol class=\"options\">\n";
                for (OptionVO op : options) {
                    outPrint += "<li id=\"option_" + op.getId() + "\">"
                            + "\n<input type=\"" + inputType
                            + "\" name=\"answerTo" + question.getId()
                            + "\" value=\"" + op.getId()
                            + "\">" + op.getAnswer()
                            + "</li>";
                }
            }
            out.print(outPrint);
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }
    }
}
