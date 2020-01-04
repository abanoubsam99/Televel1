package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC32 implements Parcelable {

    private String questionC32;
    private String option1C32;
    private String option2C32;
    private String option3C32;
    private int answerNrC32;


    public QuestionsC32() {
    }

    public QuestionsC32(String questionC32, String option1C32, String option2C32, String option3C32, int answerNrC32) {
        this.questionC32 = questionC32;
        this.option1C32 = option1C32;
        this.option2C32 = option2C32;
        this.option3C32 = option3C32;
        this.answerNrC32 = answerNrC32;
    }

    protected QuestionsC32(Parcel in) {
        questionC32 = in.readString();
        option1C32 = in.readString();
        option2C32 = in.readString();
        option3C32= in.readString();
        answerNrC32 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC32);
        dest.writeString(option1C32);
        dest.writeString(option2C32);
        dest.writeString(option3C32);
        dest.writeInt(answerNrC32);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC32> CREATOR = new Parcelable.Creator<QuestionsC32>() {
        @Override
        public QuestionsC32 createFromParcel(Parcel in) {
            return new QuestionsC32(in);
        }

        @Override
        public QuestionsC32[] newArray(int size) {
            return new QuestionsC32[size];
        }
    };


    public String getQuestionC32() {
        return questionC32;
    }

    public void setQuestionC32(String questionC32) {
        this.questionC32 = questionC32;
    }

    public String getOption1C32() {
        return option1C32;
    }

    public void setOption1C32(String option1C32) {
        this.option1C32 = option1C32;
    }

    public String getOption2C32() {
        return option2C32;
    }

    public void setOption2C32(String option2C32) {
        this.option2C32 = option2C32;
    }

    public String getOption3C32() {
        return option3C32;
    }

    public void setOption3C32(String option3C32) {
        this.option3C32 = option3C32;
    }

    public int getAnswerNrC32() {
        return answerNrC32;
    }

    public void setAnswerNrC32(int answerNrC32) {
        this.answerNrC32 = answerNrC32;
    }
}
