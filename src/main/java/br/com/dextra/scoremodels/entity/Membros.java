package br.com.dextra.scoremodels.entity;

public class Membros {

	private String id;
	private String nick;
	private String avatar;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public String toString() {
		return "Membro: [id=" + id + ", nick=" + nick + "]";
	}
}
