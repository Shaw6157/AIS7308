using DemoSharpnado.ViewModels;
using Sharpnado.Presentation.Forms.RenderedViews;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace DemoSharpnado.Views
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class TestListPage : ContentPage
    {
        ItemsViewModel viewModel;
        public HorizontalListViewLayout ListLayout { get; set; } = HorizontalListViewLayout.Linear;

        public TestListPage ()
		{
			InitializeComponent ();

            BindingContext = viewModel = new ItemsViewModel();
        }


        protected override void OnAppearing()
        {
            base.OnAppearing();

            if (viewModel.Items.Count == 0)
                viewModel.LoadItemsCommand.Execute(null);
        }
    }
}