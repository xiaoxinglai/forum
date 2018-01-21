package com.nchu;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ForumApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test() throws IOException, WriteException {
     //创建excel
		File file= new File("src/main/resources/car_test.xls");

		file.createNewFile();

			//创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(file);

		//创建sheet
		WritableSheet sheet=workbook.createSheet("sheet1",0);

		//单元格
		Label label=null;

		//数组存表头
		String[] title={"id","name","sex"};

		//设置列名
		for(int i=0;i<title.length;i++){
			label=new Label(i,0,title[i]);
			sheet.addCell(label);

		}

		for(int i=1;i<10;i++){
			//第一列  new Label(0,i,"a");    0是列   i是行
			label =new Label(0,i,"aa");
			sheet.addCell(label);
			//第二列
			label =new Label(1,i,"user");
			sheet.addCell(label);
			//第三列
			label =new Label(2,i,"男");
			sheet.addCell(label);

		}

		//写入数据
		workbook.write();
		workbook.close();
	}






}
