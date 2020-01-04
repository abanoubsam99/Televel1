package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT12 implements Parcelable {


    private String questionT12;
    private String option1T12;
    private String option2T12;
    private String option3T12;
    private int answerNrT12;


    public QuestionsT12() {
    }

    public QuestionsT12(String questionT12, String option1T12, String option2T12, String option3T12, int answerNrT12) {
        this.questionT12 = questionT12;
        this.option1T12 = option1T12;
        this.option2T12 = option2T12;
        this.option3T12 = option3T12;
        this.answerNrT12 = answerNrT12;
    }

    protected QuestionsT12(Parcel in) {
        questionT12 = in.readString();
        option1T12 = in.readString();
        option2T12 = in.readString();
        option3T12= in.readString();
        answerNrT12 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT12);
        dest.writeString(option1T12);
        dest.writeString(option2T12);
        dest.writeString(option3T12);
        dest.writeInt(answerNrT12);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT12> CREATOR = new Creator<QuestionsT12>() {
        @Override
        public QuestionsT12 createFromParcel(Parcel in) {
            return new QuestionsT12(in);
        }

        @Override
        public QuestionsT12[] newArray(int size) {
            return new QuestionsT12[size];
        }
    };

    public String getQuestionT12() {
        return questionT12;
    }

    public void setQuestionT12(String questionT12) {
        this.questionT12 = questionT12;
    }

    public String getOption1T12() {
        return option1T12;
    }

    public void setOption1T12(String option1T12) {
        this.option1T12 = option1T12;
    }

    public String getOption2T12() {
        return option2T12;
    }

    public void setOption2T12(String option2T12) {
        this.option2T12 = option2T12;
    }

    public String getOption3T12() {
        return option3T12;
    }

    public void setOption3T12(String option3T12) {
        this.option3T12 = option3T12;
    }

    public int getAnswerNrT12() {
        return answerNrT12;
    }

    public void setAnswerNrT12(int answerNrT12) {
        this.answerNrT12 = answerNrT12;
    }
}
