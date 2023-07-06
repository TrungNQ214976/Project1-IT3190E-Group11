package com.it.loganalyze.gui.application;

import java.io.IOException;
import java.security.cert.CollectionCertStoreParameters;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import com.it.loganalyze.log.Log;
import com.it.loganalyze.log.LogData;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class ShowLogTable {
	private LogData logData;
	private ArrayList<String> columns;
	TableView<Log> tableView;
	private ObservableList<Log> observableList;
	private FilteredList<Log> filteredList;
	
	public ShowLogTable(LogData log) {
		this(log, log.getKeys());	
	}
	public ShowLogTable(LogData log, ArrayList<String> cols) {
		logData = log;
		columns = cols;
		observableList = FXCollections.observableList(log.getData());
		filteredList = new FilteredList<>(observableList, p -> true); 
	}
	
	public TableView<Log> geTableView() throws IOException {
		if(columns==null) {
			return new TableView<>();
		}
		if(tableView == null) {
			tableView = new TableView<>();
			for (String i:columns) {
				TableColumn<Log, String> column = new TableColumn<Log,String>(i);
				column.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getField(i)));
				tableView.getColumns().add(column);
			}
			
			for (Log line: logData.getData()) {        	
				tableView.getItems().add(line);
			}
			
		}
		return tableView;
	}
	
	public void filterByFields(HashMap<String, Object> searchMap) {
		filteredList = tableView.getItems().filtered(log -> {
			for (String i: searchMap.keySet()) {
				boolean res;
				if(i.equals("Date")) {
					LocalDate date = log.getDate().toLocalDate();
					LocalDate searchDate = (LocalDate) searchMap.get(i); 
					res = date.isEqual(searchDate);
				} else if(i.equals("Src IP address")) {
					res = log.getSrcIp().startsWith(searchMap.get(i).toString());
				} else {
					res = log.getField(i).contains(searchMap.get(i).toString());
				}
				if(res == false) {
					return false;
				}
			}
			return true;			
		});
	    tableView.setItems(filteredList);
	}
	
}
