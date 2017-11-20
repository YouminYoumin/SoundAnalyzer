package org.androidtown.soundanalyzer;

import java.util.Objects;

public class Complex {
    private final double re; // 실수 부분
    private final double im; // 허수 부분

    // create a new object with the given real and imaginary parts
    // 주어진 실수와 허수 부분으로 새로운 객체를 생성
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if(im == 0) {
            return re + "";
        }
        if(re == 0) {
            return im + "";
        }
        if(im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }

    // 인수 제곱합의 제곱근을 반환
    public double abs() {
        return Math.hypot(re, im);
    }

    //탄젠트를 적용했을 때 지정된 두 숫자의 몫이 나오는 각도를 반환
    public double phase() {
        return Math.atan2(im, re);
    }

    // (this + b)를 한 후 새로운 객체를 생성하여 반환
    public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // (this - b)를 한 후 새로운 객체를 생성하여 반환
    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imag = a.im - b.im;
        return new Complex(real, imag);
    }

    // (this * b)를 한 후 새로운 객체를 생성하여 반환
    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new Complex(real, imag);
    }

    // (this * alpha)를 한 후 새로운 객체를 생성하여 반환
    public Complex scale(double alpha) {
        return new Complex(alpha * re, alpha * im);
    }

    // 복소켤레를 반환
    public Complex conjugate() {
        return new Complex(re, -im);
    }

    // 역수를 반환
    public Complex reciprocal() {
        double scale = re*re + im*im;
        return new Complex(re/ scale, -im / scale);
    }

    // 실수부를 반환
    public double re() {
        return re;
    }

    // 허수부를 반환
    public double im() {
        return im;
    }

    // a/b를 반환
    public Complex divides(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }

    // return a new Complex object whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // sin을 반환
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // cosine을 반환
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // tangent를 반환
    public Complex tan() {
        return sin().divides(cos());
    }

    public boolean equals(Object x) {
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Complex that = (Complex) x;
        return (this.re == that.re) && (this.im == that.im);
    }

    public int hashCode() {
        return Objects.hash(re, im);
    }
}