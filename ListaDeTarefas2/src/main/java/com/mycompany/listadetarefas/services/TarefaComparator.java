/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listadetarefas.services;

import com.mycompany.listadetarefas.model.Tarefa;
import java.util.Comparator;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class TarefaComparator implements Comparator<Tarefa> {

	private final int orderBy;
	
	public TarefaComparator(int orderBy) {
		this.orderBy = orderBy;
	}
	@Override
	public int compare(Tarefa o1, Tarefa o2) {
		return switch (orderBy) {
			case 0 -> this.compareByTitulo(o1, o2);
			case 1 -> this.compareByData(o1, o2);
			case 2 -> this.compareByStatus(o1, o2);
			default -> this.compareById(o1, o2);
		};
	}
	
	private int compareByStatus(Tarefa o1, Tarefa o2) {
		int statusCompare = compareStatus(o1, o2);
		if (statusCompare != 0) return statusCompare;
		
		int tituloCompare  = this.compareByTitulo(o1, o2);
		if (tituloCompare != 0) return tituloCompare;
		
		int dataCompare = compareByData(o1, o2);
		if (dataCompare != 0) return dataCompare;

		return this.compareById(o1, o2);
	}
	private int formatDate(Tarefa tarefa) {
		String[] parts = tarefa.getDataVencimento().split("-");
		String formatted = parts[2] + parts[1] + parts[0];
		return Integer.parseInt(formatted);
	}
	
	private int compareStatus(Tarefa t1, Tarefa t2) {
		int t1status = 0, t2status = 0;
		
		if ("pendente".equals(t1.getStatus())) t1status = 1;
		if ("pendente".equals(t2.getStatus())) t2status = 1;
	
		if (t1status > t2status) return 1;
		if (t1status < t2status) return -1;
		
		return 0;
	}

	private int compareByTitulo(Tarefa o1, Tarefa o2) {
		return o1.getTitulo().compareToIgnoreCase(o2.getTitulo());
	}

	private int compareByData(Tarefa o1, Tarefa o2) {
		return Integer.compare(formatDate(o1), formatDate(o2));
	}

	private int compareById(Tarefa o1, Tarefa o2) {
		return Integer.compare(o1.getId(), o1.getId());
	}
}
