package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT32 implements Parcelable {


    private String questionT32;
    private String option1T32;
    private String option2T32;
    private String option3T32;
    private int answerNrT32;


    public QuestionsT32() {
    }

    public QuestionsT32(String questionT32, String option1T32, String option2T32, String option3T32, int answerNrT32) {
        this.questionT32 = questionT32;
        this.option1T32 = option1T32;
        this.option2T32 = option2T32;
        this.option3T32 = option3T32;
        this.answerNrT32 = answerNrT32;
    }

    protected QuestionsT32(Parcel in) {
        questionT32 = in.readString();
        option1T32 = in.readString();
        option2T32 = in.readString();
        option3T32= in.readString();
        answerNrT32 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT32);
        dest.writeString(option1T32);
        dest.writeString(option2T32);
        dest.writeString(option3T32);
        dest.writeInt(answerNrT32);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT32> CREATOR = new Creator<QuestionsT32>() {
        @Override
        public QuestionsT32 createFromParcel(Parcel in) {
            return new QuestionsT32(in);
        }

        @Override
        public QuestionsT32[] newArray(int size) {
            return new QuestionsT32[size];
        }
    };

    public String getQuestionT32() {
        return questionT32;
    }

    public void setQuestionT32(String questionT32) {
        this.questionT32 = questionT32;
    }

    public String getOption1T32() {
        return option1T32;
    }

    public void setOption1T32(String option1T32) {
        this.option1T32 = option1T32;
    }

    public String getOption2T32() {
        return option2T32;
    }

    public void setOption2T32(String option2T32) {
        this.option2T32 = option2T32;
    }

    public String getOption3T32() {
        return option3T32;
    }

    public void setOption3T32(String option3T32) {
        this.option3T32 = option3T32;
    }

    public int getAnswerNrT32() {
        return answerNrT32;
    }

    public void setAnswerNrT32(int answerNrT32) {
        this.answerNrT32 = answerNrT32;
    }
}
