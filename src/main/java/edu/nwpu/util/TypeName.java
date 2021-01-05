package edu.nwpu.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 用于输出type对应名称的simpleTag
 *
 * @author yefeng
 *
 */
public class TypeName extends SimpleTagSupport {
    private int type;

    public void setType(int type) {this.type = type;}

    /**
     * 打印问题类型名称
     *
     * @throws JspException
     */
    public void doTag() throws JspException {
        try {
            JspWriter out = getJspContext().getOut();
            String outPrint = "";
            // 根据type设定输出
            switch (type) {
                case 0 : outPrint = "(问答题)"; break;
                case 1 : outPrint = "(单选题)"; break;
                case 2 : outPrint = "(多选题)"; break;
                default : throw new JspTagException();
            }
            out.print(outPrint);
        } catch (IOException e) {
            throw new JspTagException(e.getMessage());
        }
    }
}
