package CreationalPattern.BuilderPattern;

public class BuilderPattern {

	public static void main(String[] args) {
		// form1
		SamsungTelevisionBuilder samsungTelevisionBuilder = new SamsungTelevisionBuilder();
		samsungTelevisionBuilder.buildColor();
		samsungTelevisionBuilder.buildHeigth();
		samsungTelevisionBuilder.buildWidth();
		samsungTelevisionBuilder.buildSupportAudio();
		Television samsungTelevision = samsungTelevisionBuilder.buildTelevision();
		// form2
		TelevisionForm2Builder builder = new TelevisionForm2Builder();
		builder.buildColor("silver");
		builder.buildHeigth("100");
		builder.buildWidth("200");
		builder.buildSupportAudio("failse");
		TelevisionForm2 televisionForm2 = builder.buildTelevisionForm2();
	}

}

class Television {
	public Television(String brand) {
		this.brand = brand;
	}

	private String brand;
	private String width;
	private String heigth;
	private String color;
	private String isSupportAudio;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeigth() {
		return heigth;
	}

	public void setHeigth(String heigth) {
		this.heigth = heigth;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getIsSupportAudio() {
		return isSupportAudio;
	}

	public void setIsSupportAudio(String isSupportAudio) {
		this.isSupportAudio = isSupportAudio;
	}

}

interface TelevisionBuilder {
	public void buildWidth();

	public void buildHeigth();

	public void buildColor();

	public void buildSupportAudio();

	public Television buildTelevision();
}

class SamsungTelevisionBuilder implements TelevisionBuilder {

	private Television television = new Television("Samsung");

	@Override
	public void buildWidth() {
		television.setWidth("100");
	}

	@Override
	public void buildHeigth() {
		television.setHeigth("200");
	}

	@Override
	public void buildColor() {
		television.setColor("silver");
	}

	@Override
	public void buildSupportAudio() {
		television.setIsSupportAudio("true");
	}

	@Override
	public Television buildTelevision() {
		return this.television;
	}

}

class TelevisionForm2 {

	public TelevisionForm2(TelevisionForm2Builder builder) {
		this.brand = builder.getBrand();
		this.width = builder.getWidth();
		this.heigth = builder.getHeigth();
		this.color = builder.getColor();
		this.isSupportAudio = builder.getIsSupportAudio();
	}

	private String brand;
	private String width;
	private String heigth;
	private String color;
	private String isSupportAudio;

}

class TelevisionForm2Builder {
	private String brand;
	private String width;
	private String heigth;
	private String color;
	private String isSupportAudio;

	public String getBrand() {
		return brand;
	}

	public String getWidth() {
		return width;
	}

	public String getHeigth() {
		return heigth;
	}

	public String getColor() {
		return color;
	}

	public String getIsSupportAudio() {
		return isSupportAudio;
	}

	public TelevisionForm2Builder buildWidth(String width) {
		this.width = width;
		return this;
	}

	public TelevisionForm2Builder buildHeigth(String heigth) {
		this.heigth = heigth;
		return this;
	}

	public TelevisionForm2Builder buildColor(String color) {
		this.color = color;
		return this;
	}

	public TelevisionForm2Builder buildSupportAudio(String isSupportAudio) {
		this.isSupportAudio = isSupportAudio;
		return this;
	}

	public TelevisionForm2 buildTelevisionForm2() {
		return new TelevisionForm2(this);
	}
}