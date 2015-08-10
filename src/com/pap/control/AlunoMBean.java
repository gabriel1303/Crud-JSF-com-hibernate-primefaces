package com.pap.control;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.pap.dao.AlunoDao;
import com.pap.entity.Aluno;

@ManagedBean
@SessionScoped
public class AlunoMBean {
	
	private static final long serialVersionUID = 1L;
	private Aluno aluno;
	private AlunoDao ad;
	private List<Aluno> AlunoList;
	
	@PostConstruct
	public void init(){
		this.aluno = new Aluno();
		this.ad = new AlunoDao();
		this.AlunoList = ad.list();
	}
	public String newAluno(){
		return "manageAluno";
	}
	
	public String delete(Aluno aluno){
		ad.delete(aluno);
		return "aluno";
	}
	public String edit(Aluno aluno){
		this.aluno = aluno;
		return "manageAluno";
	}
	
	public String save() {
		ad.saveOrUpdate(aluno);
		this.aluno = new Aluno();
		return "aluno";
	}
	
	//Geters and seters
	 
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public AlunoDao getAd() {
		return ad;
	}

	public void setAd(AlunoDao ad) {
		this.ad = ad;
	}

	public List<Aluno> getAlunoList() {
		this.AlunoList = ad.list();
		return AlunoList;
	}

	public void setAlunoList(List<Aluno> alunoList) {
		AlunoList = alunoList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
