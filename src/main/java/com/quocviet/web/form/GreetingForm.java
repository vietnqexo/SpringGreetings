package com.quocviet.web.form;

import com.quocviet.domain.Color;
import com.quocviet.domain.Greeting;

public class GreetingForm {
	private Greeting greeting;
	private Color color;
	
	public Greeting getGreeting() {
		return greeting;
	}
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
