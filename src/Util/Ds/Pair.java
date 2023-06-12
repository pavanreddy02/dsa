package Util.Ds;

public class Pair<F,S> implements Comparable<Pair<F, S>> {
    F first;
    S second;


    public Pair (F first, S second){
        this.first= first;
        this.second= second;
    }

    public F getFirst(){
        return this.first;
    }

    public S getSecond(){
        return this.second;
    }

    @Override
    public int compareTo(Pair<F, S> o) {
        return (int)this.second - (int)o.second;
    }
}
