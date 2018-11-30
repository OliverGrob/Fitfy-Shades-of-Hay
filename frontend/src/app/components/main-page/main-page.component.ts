import { Component, OnInit } from '@angular/core';

import { NutrientService } from "../../services/nutrient/nutrient.service";
import { Nutrient } from "../../models/Nutrient";
import { Gym } from "../../models/Gym";
import { GymService } from "../../services/gym/gym.service";
import { Workout } from "../../models/Workout";
import { WorkoutService } from "../../services/workout/workout.service";
import { Exercise } from "../../models/Exercise";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  nutrition: Nutrient[] = [];
  gyms: Gym[] = [];
  workouts: Workout[] = [];
  show: boolean = false;
  exercises: Exercise[] = [];
  selectedExercises: Exercise[] = [];

  constructor(private nutrientService: NutrientService,
              private gymService: GymService,
              private workoutService: WorkoutService) { }

  ngOnInit() {
    this.getExercises();
  }

  calculateNutrients(nutrient: string, serving: string) {
    this.nutrientService.calculateNutrients(nutrient, serving)
      .subscribe(nutrition => {
        console.log(nutrition);
        this.nutrition = nutrition;
      });
  }

  findGyms(gym: string) {
    this.gymService.findGyms(gym)
      .subscribe(gyms => {
        console.log(gyms);
        this.gyms = gyms;
      });
  }

  findGymsByDistrict(district: string) {
    this.gymService.findGymsByDistrict(district)
      .subscribe(gyms => {
        console.log(gyms);
        this.gyms = gyms;
      });
  }

  getWorkouts() {
    this.workoutService.getWorkout()
      .subscribe(workouts => {
        console.log(workouts);
        this.workouts = workouts;
        this.show = true;
      });
  }

  addWorkout(name: string, description: string, exercises: Exercise[], day: string) {
    this.workoutService.addWorkout(name, description, exercises, day)
      .subscribe();
  }

  haveValue(): boolean {
    return this.gyms.length != 0 || this.workouts.length != 0 || this.nutrition.length != 0;
  }

  getExercises() {
    this.workoutService.getExercises()
      .subscribe(exercises => {
        console.log(exercises);
        this.exercises = exercises;
      });
  }

  clicked(exercise: Exercise, repetition) {
    console.log(exercise + ' added');
    exercise.repetition = repetition;
    if (this.selectedExercises.includes(exercise)) {
      this.selectedExercises = this.selectedExercises.filter(currentId => currentId !== exercise);
      return;
    }

    this.selectedExercises.push(exercise);
    console.log(this.selectedExercises);
  }

  sendWorkout() {
    this.workoutService.addWorkout('Dirr', 'Fuck this', this.selectedExercises, 'Monday')
      .subscribe();
  }

  alreadyChecked(exercise): boolean {
    return this.selectedExercises.includes(exercise);
  }

}
