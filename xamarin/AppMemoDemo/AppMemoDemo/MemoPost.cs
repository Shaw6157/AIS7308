using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Text;

namespace AppMemoDemo
{
    internal class MemoPost : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
    }
}
