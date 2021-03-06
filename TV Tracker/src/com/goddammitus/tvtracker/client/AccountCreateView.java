package com.goddammitus.tvtracker.client;

import com.goddammitus.tvtracker.server.model.persist.DatabaseProvider;
import com.goddammitus.tvtracker.server.model.persist.FakeDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.tvtracker.model.Account;

public class AccountCreateView extends Composite implements IsWidget{
	private TextBox txtCreateUsername;
	private PasswordTextBox txtCreatePassword;
	
	public AccountCreateView() {
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);
		
		Label lblCreateAnAccount = new Label("Create An Account");
		panel.add(lblCreateAnAccount);
		panel.setWidgetLeftWidth(lblCreateAnAccount, 160.0, Unit.PX, 119.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreateAnAccount, 21.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCreateUsername = new Label("Create Username:");
		panel.add(lblCreateUsername);
		panel.setWidgetLeftWidth(lblCreateUsername, 35.0, Unit.PX, 112.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreateUsername, 87.0, Unit.PX, 18.0, Unit.PX);
		
		Label lblCreatePassword = new Label("Create Password:");
		panel.add(lblCreatePassword);
		panel.setWidgetLeftWidth(lblCreatePassword, 35.0, Unit.PX, 112.0, Unit.PX);
		panel.setWidgetTopHeight(lblCreatePassword, 146.0, Unit.PX, 18.0, Unit.PX);
		
		txtCreateUsername = new TextBox();
		panel.add(txtCreateUsername);
		panel.setWidgetLeftWidth(txtCreateUsername, 160.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(txtCreateUsername, 81.0, Unit.PX, 34.0, Unit.PX);
		
		txtCreatePassword = new PasswordTextBox();
		panel.add(txtCreatePassword);
		panel.setWidgetLeftWidth(txtCreatePassword, 160.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(txtCreatePassword, 140.0, Unit.PX, 34.0, Unit.PX);
		
		Button btnSubmit = new Button("Submit");
		btnSubmit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleCreate();
			}
		});
		panel.add(btnSubmit);
		panel.setWidgetLeftWidth(btnSubmit, 160.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSubmit, 208.0, Unit.PX, 30.0, Unit.PX);
	}
	
	public void handleCreate() {
		RPC.loginService.checkIfAccountExists(txtCreateUsername.getText(), new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				// TODO everything
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
