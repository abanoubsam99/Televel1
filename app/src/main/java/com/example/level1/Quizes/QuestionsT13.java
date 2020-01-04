package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT13 implements Parcelable {

    private String questionT13;
    private String option1T13;
    private String option2T13;
    private String option3T13;
    private int answerNrT13;


    public QuestionsT13() {
    }

    public QuestionsT13(String questionT13, String option1T13, String option2T13, String option3T13, int answerNrT13) {
        this.questionT13 = questionT13;
        this.option1T13 = option1T13;
        this.option2T13 = option2T13;
        this.option3T13 = option3T13;
        this.answerNrT13 = answerNrT13;
    }

    protected QuestionsT13(Parcel in) {
        questionT13 = in.readString();
        option1T13 = in.readString();
        option2T13 = in.readString();
        option3T13= in.readString();
        answerNrT13 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT13);
        dest.writeString(option1T13);
        dest.writeString(option2T13);
        dest.writeString(option3T13);
        dest.writeInt(answerNrT13);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT13> CREATOR = new Creator<QuestionsT13>() {
        @Override
        public QuestionsT13 createFromParcel(Parcel in) {
            return new QuestionsT13(in);
        }

        @Override
        public QuestionsT13[] newArray(int size) {
            return new QuestionsT13[size];
        }
    };


    public String getQuestionT13() {
        return questionT13;
    }

    public void setQuestionT13(String questionT13) {
        this.questionT13 = questionT13;
    }

    public String getOption1T13() {
        return option1T13;
    }

    public void setOption1T13(String option1T13) {
        this.option1T13 = option1T13;
    }

    public String getOption2T13() {
        return option2T13;
    }

    public void setOption2T13(String option2T13) {
        this.option2T13 = option2T13;
    }

    public String getOption3T13() {
        return option3T13;
    }

    public void setOption3T13(String option3T13) {
        this.option3T13 = option3T13;
    }

    public int getAnswerNrT13() {
        return answerNrT13;
    }

    public void setAnswerNrT13(int answerNrT13) {
        this.answerNrT13 = answerNrT13;
    }
}
