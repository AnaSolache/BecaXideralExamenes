package com.examen2.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.examen2.composite.*;

class TestComposite {

	@Test
	void LeafIdea() {
		Email e = new LeafIdea("soberbio");
		assertEquals("soberbio",e.getMensaje());
	}
	
	@Test
	void LeafIdea1True() {
		Email e = new LeafIdea("soberbio");
		assertTrue("soberbio" == e.getMensaje());
	}
	
	@Test
	void LeafIdeanotNull() {
		Email e = new LeafIdea("soberbio");
		assertNotNull(e.getMensaje());
	}
	
	@Test
	void Texto() {
		Email em1 = new LeafIdea("Amor");
		Email em2 = new LeafIdea("Cariño");
		Email em3 = new Texto(em1, em2);
		assertEquals("Escribio un texto expresando: Amor y Cariño",em3.toString());
	}
	
	@Test
	void TextoFalse() {
		Email em1 = new LeafIdea("Amor");
		Email em2 = new LeafIdea("Cariño");
		Email em3 = new Texto(em1, em2);
		assertFalse("Escribio un texto expresando:" == em3.toString());
	}
	
	@Test
	void Texto2() {
		Email em1 = new LeafIdea("Amor");
		Email em2 = new LeafIdea("Cariño");
		Email em3 = new Texto(em1, em2);
		assertEquals("\n" + " tambien hay un texto expresando: " +"\n"+
			"Amor y Cariño",em3.getMensaje());
	}

	@Test
	void Imagen1() {
		Email em1 = new LeafIdea("Perritos");
		Email em2 = new LeafIdea("Gatitos");
		Email em3 = new Imagen(em1, em2);
		assertEquals("Inserto  una imagen que tiene: Perritos y Gatitos",em3.toString());
	}
	
	@Test
	void Imagen2() {
		Email em1 = new LeafIdea("Perritos");
		Email em2 = new LeafIdea("Gatitos");
		Email em3 = new Imagen(em1, em2);
		assertEquals("\n" + " tambien hay una imagen que tiene: " +"\n"
					+"Perritos y Gatitos",em3.getMensaje());
	}
	
	@Test
	void Imagen() {
		Email em1 = new LeafIdea("Amor");
		Email em2 = new LeafIdea("Cariño");
		Email em4 = new LeafIdea("Corazones");
		Email em5 = new Texto(em1,em2);
		Email em6 = new Imagen(em4,em5);
		assertEquals("\n" + " tambien hay una imagen que tiene: "+"\n"+"Corazones"+" y " +"\n" 
				+ " tambien hay un texto expresando: " +"\n"+
				"Amor y Cariño", em6.getMensaje());	
	}
	
	@Test
	@DisplayName("CalificacionExamen")
	void Pdf() {
		Email em1 = new LeafIdea("el examen");
		Email em2 = new LeafIdea("una calificacion aprobatoria");
		Email em3 = new Pdf(em1,em2);
		assertEquals("Inserto un pdf con:  el examen y una calificacion aprobatoria",em3.toString());
	}
}
