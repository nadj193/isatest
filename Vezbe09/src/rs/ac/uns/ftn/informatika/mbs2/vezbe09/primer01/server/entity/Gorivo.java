package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gorivo")
public class Gorivo implements Serializable {

	private static final long serialVersionUID = -7070493936527350889L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "gorivo_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "gorivo_tip", unique = false, nullable = false)
	private String tipGoriva;

	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "gorivo")
	private Set<Vozilo> vozila = new HashSet<Vozilo>();

	public void add(Vozilo v) {
		if (v.getGorivo() != null)
			v.getGorivo().getVozila().remove(v);
		v.setGorivo(this);
		vozila.add(v);
	}

	public void remove(Vozilo v) {
		v.setGorivo(null);
		vozila.remove(v);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipGoriva() {
		return tipGoriva;
	}

	public void setTipGoriva(String tipGoriva) {
		this.tipGoriva = tipGoriva;
	}

	public Set<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(Set<Vozilo> vozila) {
		this.vozila = vozila;
	}

	public Gorivo() {
		super();
	}

	public Gorivo(String tipGoriva, Set<Vozilo> vozila) {
		super();
		this.tipGoriva = tipGoriva;
		this.vozila = vozila;
	}

	public String toString() {
		return "(Gorivo)[id=" + id + ",tip goriva=" + tipGoriva + "]";
	}

}
