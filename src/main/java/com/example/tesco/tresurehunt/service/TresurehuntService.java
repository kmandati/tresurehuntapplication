/**
 * 
 */
package com.example.tesco.tresurehunt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.tesco.tresurehunt.dto.TresurehuntResponse;

/**
 * @author SESA568846
 *
 */
@Service
public class TresurehuntService {
	
	private static final String SUCCESS = "Success";
	
	private static final String FAILURE = "Failure";
	
	private static final String TRESURE_FOUND = "Treasure found";
	
	private static final String TRESURE_NOT_FOUND = "Treasure Not found!";	
	
	private static final String INVALID_ARRAY_SIZE="Invalid Array Size!";
	
	//BELOW METHOD ACCEPTS TRESURE INPUT ARRAY, VALIDATES WHETHER ARRAY IS VALID OR NOT
	//IF NOT VALID IT RETURNS, IF VALID IT SEARCHES FOR THE TRESURE 
	public TresurehuntResponse findTresure(int[][] tresureArray) {
		TresurehuntResponse tresurehuntResponse = new TresurehuntResponse();
		//CHECKS THE INPUT ARRAY SIZE iS SAME 
		if(!isValidTresureArray(tresureArray)) {
			tresurehuntResponse.setStatus(FAILURE);
			tresurehuntResponse.setStatusMessage(INVALID_ARRAY_SIZE);
			return tresurehuntResponse;
		}
		boolean found = false;
		int currentCellRow = 0;
		int currentCellCol = 0;
		tresurehuntResponse.setStatus(SUCCESS);
		List<String> cellsVisted = new ArrayList<String>();
		//ITERATES THE TRESURE ARRAY UNTIL A TRESURE FOUND, IF NOT FOUND IT RETURNS 
		//TRESURE NOT FOUND
		while (!found) {
			cellsVisted.add("Visited row "+ (currentCellRow + 1) + " col " + (currentCellCol + 1));
			int value = tresureArray[currentCellRow][currentCellCol];
			int nextCellCol = value % 10 - 1;
			value /= 10;
			int nextCellRow = value % 10 - 1;
			if (nextCellCol == currentCellCol && nextCellRow == currentCellRow) {
				found = true;
			} else {
				currentCellCol = nextCellCol;
				currentCellRow = nextCellRow;
			}
		}
		tresurehuntResponse.setCellsVisisted(cellsVisted);
		if(found) {
			tresurehuntResponse.setStatusMessage(TRESURE_FOUND+" at row "+ (currentCellRow + 1) + " col " + (currentCellCol + 1));
		}else {
			tresurehuntResponse.setStatusMessage(TRESURE_NOT_FOUND);

		}
		return tresurehuntResponse;
	}
	
	private boolean isValidTresureArray(int[][] tresureArray) {
		boolean isValidArray = true;
		int eachArraySize = 0;
		for(int i=0; i<tresureArray.length;i++) {
			int[] eachArray = tresureArray[i];
			if(i==0) {
				eachArraySize = eachArray.length;
			}else if(eachArraySize!=eachArray.length){
				isValidArray = false;
			}
		}
		return isValidArray;
	}

}
