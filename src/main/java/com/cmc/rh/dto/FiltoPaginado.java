package com.cmc.rh.dto;

public class FiltoPaginado {
	
	private int PagIni;
	
	private int PagFin;

	public FiltoPaginado() {
		
	}

	public int getPagIni() {
		return PagIni;
	}

	public void setPagIni(int pagIni) {
		PagIni = pagIni;
	}

	public int getPagFin() {
		return PagFin;
	}

	public void setPagFin(int pagFin) {
		PagFin = pagFin;
	}

	@Override
	public String toString() {
		return "FiltoPaginado [PagIni=" + PagIni + ", PagFin=" + PagFin + "]";
	}
	
	
	
	

}
