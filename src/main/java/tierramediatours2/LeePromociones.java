package tierramediatours2;

public class LeePromociones {
	private String tipo_pack;
	private Float desc_prom;
	private String atraccion1;
	private Integer cupo1;
	private String atraccion2;
	private Integer cupo2;
	private String atraccion3;
	private Integer cupo3;

	public Integer getCupo1() {
		return cupo1;
	}

	public void setCupo1(Integer cupo1) {
		this.cupo1 = cupo1;
	}

	public Integer getCupo2() {
		return cupo2;
	}

	public void setCupo2(Integer cupo2) {
		this.cupo2 = cupo2;
	}

	public Integer getCupo3() {
		return cupo3;
	}

	public void setCupo3(Integer cupo3) {
		this.cupo3 = cupo3;
	}

	public String getTipo_pack() {
		return tipo_pack;
	}

	public void setTipo_pack(String tipo_pack) {
		this.tipo_pack = tipo_pack;
	}

	public Float getDesc_prom() {
		return desc_prom;
	}

	public void setDesc_prom(Float desc_prom) {
		this.desc_prom = desc_prom;
	}

	public String getAtraccion1() {
		return atraccion1;
	}

	public void setAtraccion1(String atraccion1) {
		this.atraccion1 = atraccion1;
	}

	public String getAtraccion2() {
		return atraccion2;
	}

	public void setAtraccion2(String atraccion2) {
		this.atraccion2 = atraccion2;
	}

	public String getAtraccion3() {
		return atraccion3;
	}

	public void setAtraccion3(String atraccion3) {
		this.atraccion3 = atraccion3;
	}


	public LeePromociones(String tipo_pack, Float desc_prom, String atraccion1, Integer cupo1, String atraccion2,
			Integer cupo2, String atraccion3, Integer cupo3) {
		super();
		this.tipo_pack = tipo_pack;
		this.desc_prom = desc_prom;
		this.atraccion1 = atraccion1;
		this.cupo1 = cupo1;
		this.atraccion2 = atraccion2;
		this.cupo2 = cupo2;
		this.atraccion3 = atraccion3;
		this.cupo3 = cupo3;
	}

	@Override
	public String toString() {
		return "LeePromociones [tipo_pack=" + tipo_pack + ", desc_prom=" + desc_prom + ", atraccion1=" + atraccion1
				+ ", cupo1=" + cupo1 + ", atraccion2=" + atraccion2 + ", cupo2=" + cupo2 + ", atraccion3=" + atraccion3
				+ ", cupo3=" + cupo3 + "]";
	}

	
}
