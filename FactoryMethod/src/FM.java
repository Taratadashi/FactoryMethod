
public class FM {
	public static void main(String[] args) {
		Koujyou koujyou1 = new TvKoujyou();
		Koujyou koujyou2 = new RadioKoujyou();
		Seihin[] array = new Seihin[3];
		array[0] = koujyou1.create();
		array[1] = koujyou2.create();
		array[2] = koujyou1.create();
		for (int i = 0; i < array.length; ++i) {
			array[i].print();
			}
		}
	}

abstract class Koujyou {
	public final Seihin create() {
		Seihin seihin = factoryMethod();
		touroku(seihin);
		return seihin;
		}
	public abstract Seihin factoryMethod();
	public abstract void touroku(Seihin s);
	}

class TvKoujyou extends Koujyou {
	public Seihin factoryMethod() {
		return new Television();
		}
	public void touroku(Seihin s) {
		Television t = (Television) s;
		t.numberring(); t.setDate(Date.today());
		}
	}

class RadioKoujyou extends Koujyou {
	public Seihin factoryMethod() {
		return new Radio();
	}
	public void touroku(Seihin s) {
		Radio r = (Radio) s;
		r.numberring();
		}
	}

abstract class Seihin {
	public abstract void print();
}

class Television extends Seihin {
	private int tvSerialNumber;
	private String date;

	public void numberring() {
		tvSerialNumber = Counter.getTvNumber();
		}

	public void setDate(String date) {             //製造年月日を習得
		this.date = date;
		}
	public void print() {                          //テレビに関する情報を出力
		System.out.println("このテレビに関する情報:");
		System.out.println(" 製造番号:" + tvSerialNumber);
		System.out.println(" 製造年月日:" + date);
		}
}

class Radio extends Seihin {
	private int radioSerialNumber;
	public void numberring() {
		radioSerialNumber = Counter.getRadioNumber();
		}
	public void print() {                           //ラジオに関する情報を出力
		System.out.println("このラジオに関する情報:");
		System.out.println(" 製造番号:" + radioSerialNumber);
		}
	}

class Date {
	public static String today() {
		return "2020/01/20";           //製造年月日登録
		}
	}

class Counter {
	private static int tvNum = 100;    //テレビの製造番号を登録
	private static int radioNum = 76;  //ラジオの製造番号を登録

	public static int getTvNumber() {
		return tvNum++;             //テレビの製造番号を習得
		}

	public static int getRadioNumber() {
		return radioNum++;         //ラジオの製造番号を習得
		}
	}




