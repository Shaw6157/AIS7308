using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Demo0607.Views
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class UserLogin : ContentPage
	{
		public UserLogin ()
		{
			InitializeComponent ();
		}

        async void Click_Page_Register(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new UserRegister());
        }
        async void Click_Login(object sender, EventArgs e)
        {
            await Navigation.PopAsync();
        }
    }
}