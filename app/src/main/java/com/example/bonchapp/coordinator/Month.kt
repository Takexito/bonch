package com.example.bonchapp.coordinator

enum class Month {
    JANUARY
    {
        override fun toString(): String {
            return "Январь"
        }
    },
    FEBRUARY
    {
        override fun toString(): String {
            return "Февраль"
        }
    },
    MARCH
    {
        override fun toString(): String {
            return "Март"
        }
    },
    APRIL{
        override fun toString(): String {
            return "Апрель"
        }
    },
    MAY{
        override fun toString(): String {
            return "Май"
        }
    },
    JUNE{
        override fun toString(): String {
            return "Июнь"
        }
    },
    JULY{
        override fun toString(): String {
            return "Июль"
        }
    },
    AUGUST{
        override fun toString(): String {
            return "Август"
        }
    },
    SEPTEMBER{
        override fun toString(): String {
            return "Сентябрь"
        }
    },
    OCTOBER{
        override fun toString(): String {
            return "Октябрь"
        }
    },
    NOVEMBER{
        override fun toString(): String {
            return "Ноябрь"
        }
    },
    DECEMBER{
        override fun toString(): String {
            return "Декабрь"
        }
    };

}