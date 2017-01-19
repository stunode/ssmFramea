import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * 使用Itext工具对PDF操作
 */
public class fillTemplate {
    public static void main(String[] args) throws Exception {

        String TemplatePDF = "D:\\1227iglp_rushorder\\iglp\\iglp-web\\src\\main\\webapp\\static\\template\\contractTemplate.pdf";//设置模板路径


        PdfReader reader = new PdfReader(TemplatePDF);
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        PdfStamper pdfStamper = new PdfStamper(reader, byteOut);//包装模板到byteOut流

        AcroFields acroFields = pdfStamper.getAcroFields();//获取文档中可编辑域
        BaseFont bcf = BaseFont.createFont("C:\\Users\\Administrator\\Downloads\\iTEXTpdf\\SIMYOU.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        //设置可编译域属性，"orderSeq"，"handsYear"是模板中定义的属性
        acroFields.setFieldProperty("orderSeq", "textfont", bcf, null);
        acroFields.setFieldProperty("handsYear", "textfont", bcf, null);

        //设置合同内容
        acroFields.setField("orderSeq", "88888888");
        acroFields.setField("handsYear", "1988");
        pdfStamper.setFormFlattening(true);
        pdfStamper.close();

        //需要生成的文件名字
        String pdfName =  "iText.pdf";

        //生成合同文件
        File file = createFile(System.getProperty("java.io.tmpdir") + "/input.pdf");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(byteOut.toByteArray());

        outputStream.close();
        reader.close();
    }

    /**
     * 创建文件,如果文件所在的目录不存在，先创建文件的目录
     *
     * @param path 文件全路径
     * @return 创建的文件
     * @throws IOException
     */
    public static File createFile(String path) throws IOException {
        path = resolveDir(path);
        int idx = path.lastIndexOf("/");
        if (idx > 0) {
            File dir = new File(path.substring(0, idx));
            dir.mkdirs();
        }
        File file = new File(path);
        if (file.exists()) file.delete();
        file.createNewFile();
        return file;
    }

    /**
     * 解决Windows,Linux等操作系统文件分隔符不同的问题，统一使用/作为文件分隔符
     *
     * @param dirPath 文件路径
     * @return 处理后的文件路径
     */
    public static String resolveDir(String dirPath) {
        dirPath = StringUtils.replaceChars(dirPath, '\\', '/');
        dirPath = StringUtils.replace(dirPath, "//", "/");
        return dirPath;
    }
}
