import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {HeaderComponent} from './components/header/header.component';
import {LoginComponent} from './components/login/login.component';
import {AdminComponent} from './components/admin/admin.component';
import {ToursComponent} from './components/tours/tours.component';
import {DetailsComponent} from './components/details/details.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {AdminGuard} from './components/guards/auth/admin.guard';


const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', redirectTo: '', component: HomeComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AdminGuard]},
  {path: 'tours', component: ToursComponent},
  {path: 'details', component: DetailsComponent},
  {path: 'login', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]

})
export class AppRoutingModule {
}

export const routingComponents = [HomeComponent, HeaderComponent, LoginComponent, AdminComponent, ToursComponent, DetailsComponent, LoginComponent, RegistrationComponent]
