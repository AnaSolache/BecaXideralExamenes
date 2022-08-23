package com.examen2.composite;

public class LeafIdea implements Email{
	
	String idea;
	
	public LeafIdea(String idea) {
		this.idea = idea;
	}

	@Override
	public String getMensaje() {
		return idea;
	}

	@Override
	public String toString() {
		return idea;
	}
	
	
}
