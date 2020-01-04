package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC13 implements Parcelable {


    private String questionC13;
    private String option1C13;
    private String option2C13;
    private String option3C13;
    private int answerNrC13;


    public QuestionsC13() {
    }

    public QuestionsC13(String questionC13, String option1C13, String option2C13, String option3C13, int answerNrC13) {
        this.questionC13 = questionC13;
        this.option1C13 = option1C13;
        this.option2C13 = option2C13;
        this.option3C13 = option3C13;
        this.answerNrC13 = answerNrC13;
    }

    protected QuestionsC13(Parcel in) {
        questionC13 = in.readString();
        option1C13 = in.readString();
        option2C13 = in.readString();
        option3C13= in.readString();
        answerNrC13 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC13);
        dest.writeString(option1C13);
        dest.writeString(option2C13);
        dest.writeString(option3C13);
        dest.writeInt(answerNrC13);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC13> CREATOR = new Parcelable.Creator<QuestionsC13>() {
        @Override
        public QuestionsC13 createFromParcel(Parcel in) {
            return new QuestionsC13(in);
        }

        @Override
        public QuestionsC13[] newArray(int size) {
            return new QuestionsC13[size];
        }
    };

    public String getQuestionC13() {
        return questionC13;
    }

    public void setQuestionC13(String questionC13) {
        this.questionC13 = questionC13;
    }

    public String getOption1C13() {
        return option1C13;
    }

    public void setOption1C13(String option1C13) {
        this.option1C13 = option1C13;
    }

    public String getOption2C13() {
        return option2C13;
    }

    public void setOption2C13(String option2C13) {
        this.option2C13 = option2C13;
    }

    public String getOption3C13() {
        return option3C13;
    }

    public void setOption3C13(String option3C13) {
        this.option3C13 = option3C13;
    }

    public int getAnswerNrC13() {
        return answerNrC13;
    }

    public void setAnswerNrC13(int answerNrC13) {
        this.answerNrC13 = answerNrC13;
    }
}
