package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC23 implements Parcelable {


    private String questionC23;
    private String option1C23;
    private String option2C23;
    private String option3C23;
    private int answerNrC23;


    public QuestionsC23() {
    }

    public QuestionsC23(String questionC23, String option1C23, String option2C23, String option3C23, int answerNrC23) {
        this.questionC23 = questionC23;
        this.option1C23 = option1C23;
        this.option2C23 = option2C23;
        this.option3C23 = option3C23;
        this.answerNrC23 = answerNrC23;
    }

    protected QuestionsC23(Parcel in) {
        questionC23 = in.readString();
        option1C23 = in.readString();
        option2C23 = in.readString();
        option3C23= in.readString();
        answerNrC23 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC23);
        dest.writeString(option1C23);
        dest.writeString(option2C23);
        dest.writeString(option3C23);
        dest.writeInt(answerNrC23);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC23> CREATOR = new Parcelable.Creator<QuestionsC23>() {
        @Override
        public QuestionsC23 createFromParcel(Parcel in) {
            return new QuestionsC23(in);
        }

        @Override
        public QuestionsC23[] newArray(int size) {
            return new QuestionsC23[size];
        }
    };


    public String getQuestionC23() {
        return questionC23;
    }

    public void setQuestionC23(String questionC23) {
        this.questionC23 = questionC23;
    }

    public String getOption1C23() {
        return option1C23;
    }

    public void setOption1C23(String option1C23) {
        this.option1C23 = option1C23;
    }

    public String getOption2C23() {
        return option2C23;
    }

    public void setOption2C23(String option2C23) {
        this.option2C23 = option2C23;
    }

    public String getOption3C23() {
        return option3C23;
    }

    public void setOption3C23(String option3C23) {
        this.option3C23 = option3C23;
    }

    public int getAnswerNrC23() {
        return answerNrC23;
    }

    public void setAnswerNrC23(int answerNrC23) {
        this.answerNrC23 = answerNrC23;
    }
}
