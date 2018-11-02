package com.main;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.soap.PatientDetailSoap;
import com.soap.PatientDetailSoap_Service;
import com.soap.PatientDetails;

public class GetAllPatientDetails extends Shell {
Shell shell=this;
	

	
	

	public GetAllPatientDetails(Display display) {
	// TODO Auto-generated constructor stub
		super(display,SWT.SHELL_TRIM);
		createContents();
	}





	private void createContents() {
		// TODO Auto-generated method stub
		setText("EyeCare");
		setSize(450,400);
		Label label=new Label(shell,SWT.NONE);
		label.setBounds(20,20,120,30);
		label.setText("Welcome to EyeCare");
		
		Button button1=new Button(shell, SWT.FLAT);
		button1.setBounds(20,50,190,50);
		button1.setText("Get Details Of Patient");
		Combo combo=new Combo(shell, SWT.SIMPLE);;
		
		Text text1=new Text(shell,SWT.SINGLE|SWT.READ_ONLY);
		text1.setBounds(50,200,80,50);
		
		Text text2=new Text(shell,SWT.SINGLE|SWT.READ_ONLY);
		text2.setBounds(150,200,80,50);
		
		Text text3=new Text(shell,SWT.SINGLE|SWT.READ_ONLY);
		text3.setBounds(250,200,100,50);
		
		Text text4=new Text(shell,SWT.SINGLE|SWT.READ_ONLY);
		text4.setBounds(350,200,80,50);
		
		Label label2=new Label(shell,SWT.NONE);
		label2.setBounds(150, 170,80, 50);
		
		
		
		
		button1.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
				label2.setBounds(250,50,80, 50);
				label2.setText("Select CardID");
				combo.setBounds(250,70, 80, 100);
				
				PatientDetailSoap_Service paitientService=new PatientDetailSoap_Service();
				PatientDetailSoap newPort = paitientService.getNewPort();
				List<PatientDetails> allPatientDetails = newPort.getAllPatientDetails();
				
				for(PatientDetails patient:allPatientDetails)
				{
					combo.add(Integer.toString(patient.getCardId()));
					System.out.println(patient.getPatientName());
					
				}
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		combo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				PatientDetailSoap_Service paitientService=new PatientDetailSoap_Service();
				PatientDetailSoap newPort = paitientService.getNewPort();
				List<PatientDetails> allPatientDetails = newPort.getAllPatientDetails();
				
				int selectionIndex = combo.getSelectionIndex();
				String text = combo.getText();
				int cardId = Integer.parseInt(text);
				for(PatientDetails patient:allPatientDetails)
				{
					if(patient.getCardId()==cardId)
					{
						text1.setText(patient.getPatientName());
						text2.setText(Integer.toString(patient.getAge()));
						text3.setText(patient.getMobileNo());
						text4.setText(patient.getAddress());
						break;
					}
					
				}
				
				
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	
		
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Display display=Display.getDefault();
			GetAllPatientDetails shell=new GetAllPatientDetails(display);
			shell.open();
			shell.layout();
			while(!shell.isDisposed())
			{
				if(!display.readAndDispatch())
				{
					display.sleep();
				}
				
			}
			display.dispose();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@Override
	protected void checkSubclass()
	{
		
	}

	

}
