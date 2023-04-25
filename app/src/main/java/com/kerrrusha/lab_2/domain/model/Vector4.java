package com.kerrrusha.lab_2.domain.model;

public class Vector4 <R> {

    private final R first, second, third, fourth;

    public Vector4(R first, R second, R third, R fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public R getFirst() {
        return first;
    }

    public R getSecond() {
        return second;
    }

    public R getThird() {
        return third;
    }

    public R getFourth() {
        return fourth;
    }

}
