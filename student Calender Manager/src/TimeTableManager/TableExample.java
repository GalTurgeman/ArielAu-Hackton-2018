package TimeTableManager;
import javax.swing.*;    
public class TableExample {    
	JFrame f;    
	TableExample(){    
		f=new JFrame();    
		String data[][]={ {"09:00-10:00","Amit \n\b 51.2.51","670000","101","Amit","670000","g"},    
				{"10:00-11:00","Jai","780000","102","Jai","780000","t"},    
				{"11:00-12:00","Sachin","700000","101","Sachin","700000","f"}};    
		String column[]={"Hour","Sunday","Monday","Thuresday","Thuesday","Wendesday","Friday"};         
		JTable jt=new JTable(data,column);    
		jt.setBounds(30,40,500,600);     
		JScrollPane sp=new JScrollPane(jt);    
		f.add(sp);          
		f.setSize(600,500);    
		f.setVisible(true);    
	}     //
	public static void main(String[] args) {    
		    new TableExample();
	}    
}  