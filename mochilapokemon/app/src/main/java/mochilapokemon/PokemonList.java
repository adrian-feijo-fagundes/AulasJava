/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mochilapokemon;

import java.util.ArrayList;

/**
 *
 * @author ADRIANFEIJOFAGUNDES
 */
public class PokemonList {
	private ArrayList<Pokemon> pokemonDB;
	private Pokemon[] mochila;
	
	public PokemonList() {
		pokemonDB = new ArrayList<>();
		mochila = new Pokemon[6];
	}
	
	public void adicionarPokemonDB(ArrayList<Pokemon>  pokemons) {
	
	}
	public void addPokemon(Pokemon pokemon) {}
	public Pokemon getPokemon(String nome) {
		for (Pokemon pokemon: pokemonDB) {
			
			
			//return pokemonDB.get()
		}
		return null;
	}
	public void removePokemon(Pokemon pokemon) {}
	
	public void removerDaMochila(Pokemon pokemon) {}
	public void adicionarNaMochilla(Pokemon pokemon) {}
	public void verPokemonsNaMochila() {}
	
}
