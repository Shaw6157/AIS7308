using System;

using Demo0607.Models;

namespace Demo0607.ViewModels
{
    public class ItemDetailViewModel : BaseViewModel
    {
        public Toy Item { get; set; }
        public ItemDetailViewModel(Toy item = null)
        {
            Title = item?.Name;
            Item = item;
        }
    }
}
